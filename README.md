## 🔐 Autenticación con Spring Security + JWT

Se añadió autenticación basada en tokens JWT utilizando **Spring Security**. A continuación, se detallan los cambios más importantes realizados:

---

### 🧱 Estructura general

- `SecurityConfig`: configuración de seguridad principal.
- `JwtAuthenticationFilter`: filtro que intercepta peticiones y valida JWTs.
- `JwtService`: clase encargada de generar, validar y extraer información del token.
- `AuthenticationService`: clase encargada del login y registro.
- `User`: entidad de usuario.
- `UserRepository`: interfaz de acceso a la base de datos de usuarios.
- `Role`: enum con los posibles roles del sistema.
- `AuthenticationRequest / RegisterRequest`: DTOs para el login y el registro.
- `AuthenticationResponse`: DTO que devuelve el token generado.

---

### 🔑 Endpoints públicos

| Método | Ruta        | Descripción        |
|--------|-------------|--------------------|
| POST   | `/auth/login`    | Inicia sesión con email y password. Devuelve un JWT. |
| POST   | `/auth/register` | Registra un nuevo usuario. Devuelve un JWT. |

> Todos los demás endpoints requieren un token JWT válido en el header `Authorization`.

---

### 🧪 Ejemplo de uso (con curl o Postman)

**Login:**

```http
POST /auth/login
Content-Type: application/json

{
  "email": "ejemplo@correo.com",
  "password": "123456"
}
```
```
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```
### Enviar en cada request protegida:
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR...

## 🔐 Seguridad
- CSRF deshabilitado.
- Sesión STATELESS.
- Filtro JWT se ejecuta antes de UsernamePasswordAuthenticationFilter.
- Email de usuario es único (usando @Column(unique = true)).

## 🛡️ Validación del Token
- Firma HMAC SHA256.
- Verifica:
- Caducidad del token.
- Correo electrónico del usuario.
- Que el usuario esté en la base de datos.
