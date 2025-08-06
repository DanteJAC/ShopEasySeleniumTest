Selenium Automation – The Internet (Herokuapp)

🧪 Descripción del Proyecto
Este proyecto automatiza pruebas funcionales en el sitio público The Internet, utilizando Selenium WebDriver y JUnit 5. Las pruebas incluidas son:

✅ LoginTest: Verifica el login exitoso y fallido.

✅ FormInputTest: Valida la entrada de datos numéricos en un campo de formulario.
Ambas clases utilizan esperas explícitas, validaciones con Assertions y generan un informe en consola al ejecutar las pruebas.

📦 Requisitos

* Java JDK 11 o superior
* Maven instalado
* Google Chrome
* Conexión a internet para descargar dependencias
* Visual Studio Code (opcional)

📁 Estructura del Proyecto

```
ShopEasySeleniumTest/
├── pom.xml
└── src/
├── main/
│   └── java/
└── test/
└── java/
└── com/
└── shopeasy/
├── LoginTest.java
└── FormInputTest.java
```

⚙️ Instalación
1. Clona o descarga el proyecto.
2. Abre una terminal en la raíz del proyecto.
3. Ejecuta:

Esto descargará las dependencias necesarias.

🚀 Ejecución de Pruebas
Para ejecutar todas las pruebas:


Cada clase imprimirá en consola un informe con:

* Estado de la prueba
* Valores ingresados
* Mensajes de validación
* Estado del navegador
* Notas Adicionales
* El sitio de pruebas es público y no requiere registro.
* Credenciales válidas para login:
* Usuario: tomsmith
* Contraseña: SuperSecretPassword!
* Puedes extender el proyecto para probar otros módulos como:
* Formularios de recuperación de contraseña
* Subida de archivos
* Tablas dinámicas
* Autenticación básica
