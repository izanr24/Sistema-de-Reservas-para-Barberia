# 💈 Sistema de Citas para Barbería

Sistema completo de gestión de citas para barbería con frontend y backend en Node.js.

## 🚀 Características

- ✅ **Reserva de citas online** con horarios disponibles en tiempo real
- ✅ **Gestión inteligente de horarios** - solo muestra horas disponibles
- ✅ **Múltiples servicios** - corte, barba, afeitado, facial
- ✅ **Selección de barbero** preferido (opcional)
- ✅ **Cálculo automático** de precios y duración
- ✅ **Validaciones completas** de datos
- ✅ **Base de datos MongoDB** para persistencia
- ✅ **API REST** completa
- ✅ **Panel de administración** (próximamente)

## 📋 Requisitos

- **SpringBoot**
- **PostgreSql**
- **Navegador web**

## 🛠️ Instalación

### 1. Clonar el repositorio
```bash
git clone <tu-repositorio>
cd barberia-app
```

### 2. Instalar dependencias del backend
```bash
cd Back
npm install
```

### 3. Configurar variables de entorno
Edita el archivo `Back/.env` con tus datos:

```env
# Base de datos PostgreSql
MONGODB_URI=mongodb://localhost:27017/barberia
# O usa MongoDB Atlas:
# MONGODB_URI=mongodb+srv://usuario:password@cluster.mongodb.net/barberia

# Configuración de email (opcional)
EMAIL_USER=tu_email@gmail.com
EMAIL_PASS=tu_app_password
```

### 4. Inicializar la base de datos
```bash
cd Back
node scripts/initDB.js
```

### 5. Iniciar el servidor
```bash
npm run dev
# O para producción:
npm start
```

El servidor estará disponible en: `http://localhost:3000`

### 6. Abrir el frontend
Abre el archivo `Front/html/solicitarCita.html` en tu navegador.

## 📁 Estructura del proyecto

```
barberia-app/
├── Front/                  # Frontend
│   ├── html/
│   │   ├── index.html
│   │   └── solicitarCita.html
│   ├── js/
│   │   └── citas.js       # Lógica de citas
│   ├── css/               # Estilos
│   └── img/               # Imágenes
├── Back/                   # Backend Node.js
│   ├── models/            # Modelos de MongoDB
│   │   ├── Cliente.js
│   │   ├── Barbero.js
│   │   ├── Cita.js
│   │   └── Servicio.js
│   ├── routes/            # Rutas de la API
│   │   ├── citas.js
│   │   ├── servicios.js
│   │   ├── barberos.js
│   │   ├── clientes.js
│   │   └── admin.js
│   ├── scripts/
│   │   └── initDB.js      # Inicializar BD
│   ├── server.js          # Servidor principal
│   ├── package.json
│   └── .env               # Variables de entorno
└── README.md
```

## 🔧 API Endpoints

### Citas
- `GET /api/citas/disponibilidad/:fecha` - Horarios disponibles
- `POST /api/citas` - Crear nueva cita
- `GET /api/citas/:id` - Obtener cita por ID
- `PUT /api/citas/:id/estado` - Actualizar estado
- `DELETE /api/citas/:id` - Cancelar cita

### Servicios
- `GET /api/servicios` - Listar servicios
- `GET /api/servicios/:codigo` - Obtener servicio

### Barberos
- `GET /api/barberos` - Listar barberos
- `GET /api/barberos/:id` - Obtener barbero

### Admin
- `GET /api/admin/dashboard` - Estadísticas
- `GET /api/admin/citas/calendario/:fecha` - Calendario

## 💡 Uso del sistema

### Para clientes:
1. Visita `solicitarCita.html`
2. Selecciona uno o más servicios
3. Elige una fecha (lunes a viernes)
4. Selecciona un horario disponible
5. Completa tus datos y confirma

### Para administradores:
- Accede a las rutas `/api/admin/*` para estadísticas
- Usa herramientas como Postman para gestionar citas

## 🎯 Configuración de horarios

En el archivo `.env` puedes configurar:

```env
# Horarios de trabajo
HORARIO_INICIO=9          # 9:00 AM
HORARIO_FIN=20           # 8:00 PM
INTERVALO_MINUTOS=30     # Slots de 30 minutos

# Días cerrados (0=Domingo, 6=Sábado)
DIAS_CERRADOS=0,6        # Cerrado fines de semana
```

## 🔍 Solución de problemas

### Error de conexión a MongoDB
```bash
# Verificar que MongoDB esté corriendo
mongod --version

# O usar MongoDB Atlas (cloud)
# Actualiza MONGODB_URI en .env
```

### Error CORS en el navegador
- Asegúrate de que el servidor esté corriendo en puerto 3000
- Verifica que el frontend use `http://localhost:3000/api`

### Los horarios no aparecen
1. Verifica que el servidor esté corriendo
2. Abre las herramientas de desarrollador (F12)
3. Revisa la consola por errores
4. Asegúrate de seleccionar servicios y fecha válida

## 📊 Datos de prueba

El script `initDB.js` crea:

### Servicios:
- **Corte de pelo** - 30 min - 8€
- **Recorte de barba** - 20 min - 9€  
- **Afeitado completo** - 25 min - 10€
- **Mascarilla facial** - 45 min - 15€

### Barberos:
- **Johnny Lawrence** - Especialista en cortes clásicos
- **Daniel LaRusso** - Experto en tratamientos faciales
- **Tory Nichols** - Barbera versátil
- **Samantha LaRusso** - Especialista en cortes modernos

## 🚀 Próximas mejoras

- [ ] Panel de administración web
- [ ] Notificaciones por email/SMS
- [ ] Sistema de calificaciones
- [ ] Integración con calendario
- [ ] App móvil
- [ ] Pagos online

## 📞 Soporte

Si tienes problemas:
1. Revisa este README
2. Verifica los logs del servidor
3. Comprueba la consola del navegador
4. Asegúrate de que MongoDB esté corriendo

---

**¡Tu barbería ahora tiene un sistema de citas profesional! 💈✨**