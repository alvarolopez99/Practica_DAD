# Sapiotheca

## Temática 
Aplicación para visualizar cursos, repositorio para apuntes y anuncios de clases particulares. Los usuarios premium tendrían acceso a otro tipo de servicios, como acceso al foro comunitario para resolución de dudas o chat privado personalizado con el profesor. 
Los usuarios estándar podrían ver mensajes en el foro escritos por otros usuarios, ciertos contenidos de los cursos, y los anuncios de los profesores, pero no podrían escribir un nuevo post, o contratar una clase con un profesor.
Los posts del foro pueden ser escritos por los usuarios que tengan servicio premium, pero los que tengan un plan standard solo podrán visualizarlos. Obviamente, los desarrolladores tienen acceso a esos posts para controlar que no se publique nada ofensivo.
Los posts se componen de mensajes, enviados cada uno por un usuario distinto, que incluye el usuario que lo envío, y el contenido en sí.
Los chats serían privados entre un usuario y un profesor, se almacenaría el histórico de mensajes que han intercambiado.
Los anuncios de clases particulares publicados por cada profesor son visibles por todos los usuarios, aunque solo sería posible hablar mediante un chat privado con el profesor que ha publicado ese anuncio si eres usuario premium.
Los cursos se componen de una serie de contenidos (pdfs) y estarían disponibles para todos los usuarios.
Solo se pueden examinar del curso los usuarios premium, y al completarlo se obtiene un certificado que se enviaría por correo.
Los profesores pueden crear nuevos cursos y crear un examen por cada curso.
Por su parte, el administrador, además de las funciones de los usuarios premium, podría dar de alta a un profesor.



## Entidades 
- Usuarios: Usuarios que utilizan la página web. Pueden ser de tipo alumno, profesor o administrador. Proporcionan sus datos al registrarse.
- Posts del foro: hilo del foro sobre algún tema, duda, curiosidad, donde puede participar los usuarios premium.
- Chat: Historial de chat entre un usuario y un profesor. Contiene una lista de mensajes.
- Mensaje: Cada uno de los mensajes que contiene un post o un chat. Incluyen nombre del usuario que lo ha enviado y contenido.
- Anuncios: Diferentes posts de anuncio que los profesores ponen en un apartado especial para poder ser contratados como profesores particulares.
- Curso: Cursos temáticos compuestos de material PDF, para que los usuarios puedan visualizarlos directamente. No se pueden descargar. Cada curso contiene un examen final de evaluación.
- Examen: Examen de evaluación compuesto por 5 preguntas. El usuario puede completarlo para recibir un certificado en su correo electrónico.
- Pregunta: Compuesta por un enunciado y una respuesta.



## Servicio interno
- Envío de correos con el certificado: Cuando un usuario termine un curso, el servicio interno se encarga de generar y mandar el correo con el certificado generado al usuario determinado.
- Filtrado de lenguaje soez: Cuando un usuario utiliza palabras malsonantes, el sistema lo reemplazará por una censura a dicha palabra.
- Reescalado de imágenes: Al seleccionar una imagen de perfil, esta será reescalada para adaptarse al tamaño 300x300 de la web.


## Diagramas de la aplicación


### Diagrama de navegación
![](https://github.com/alvarolopez99/Saphioteca/blob/main/DiagramasDAD/DiagramaNavegacion.png)

### Diagrama UML
![](https://github.com/alvarolopez99/Saphioteca/blob/main/DiagramasDAD/UMLDAD.png)

### Diagrama E/R
![](https://github.com/alvarolopez99/Saphioteca/blob/main/DiagramasDAD/ERDAD.png)


## Capturas de Pantalla - FASE III

Capturas pertenecientes al resultado final de la fase III de desarrollo:


### Pantalla de inicio

Pagina genérica disponible para todos los usuarios desde donde poder acceder registrarse o logearse

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/1PaginaInicio.PNG)


### Login

Pagina para poder logearse y acceder

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/2Login.PNG)


### Registro

Pagina para poder hacer el registro de alumno accesible a cualquier persona

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/3Registro.PNG)


### Registro finalizado

Pagina de confirmacion del registro

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/4RegistroFinalizado.PNG)


### Pagina Principal

Pagina principal que aparece una ver nos hemos logeado

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/5PaginaPrincipal.PNG)


### Pagina Principal Administrador

Pagina principal desde la visión del administrador

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/6PaginaPrincipalAdmin.PNG)


### Curso profesor

Pagina de los cursos desde la vision del profesor que puede crear cursos

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/7CursosProfesor.PNG)


### Crear curso

Pagina de creacion de cursos disponible para profesores

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/8CrearCurso.PNG)


### Crear examen

Pagina de creacion de examenes disponible para profesores

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/9CrearExamen.PNG)


### Cursos usuarios

Vision para los usuarios de los cursos disponibles

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/14_Cursos_Usuario.PNG)


### Contenido curso

Pagina donde se puede visualizar el contenido de un curso

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/15_Ver_Contenido_Curso_Usuario.PNG)


### Perfil

Pagina de perfil para usuarios logeados

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/10_Perfil.PNG)


### Foros alumnos

Lista de foros que ven los alumnos

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/17_Foros_Alumno.PNG)


### Respuestas en foros

Respuesta a un foro

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/18_Responder_Foro.PNG)


### Intercambio mensajes foros

Distintos mensajes en un foro (disponible para usuarios registrados y logeados)

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/19_Intercambio_Mensajes_Foro.PNG)


### Anuncios

Vision de los anuncios para profesores donde se pueden crear

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/21_Anuncios_Alumno.PNG)


### Anuncio alumno

Vista de alumnos de los anuncios de profesores disponibles

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/22_Anuncio_Alumno.PNG)


### Chats de profesor

Lista de chats disponible para profesores

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/23_Chats_Profesor.PNG)


### Chat

Chat desde la vista de un alumno

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/24_Chat.PNG)


### Filtrado lenguaje

El filtrado del lenguaje cambia por "***" las palabrotas que se intenten poner en la aplicación

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDADFaseIII/25_Filtrado_Lenguaje.PNG)



## Integrantes del grupo

- Sergio Arévalo Gil -> s.arevalog.2017@alumnos.urjc.es - SergioE17

- Pablo Bayona González -> p.bayona.2017@alumnos.urjc.es - pbayona

- Carlos Colmenero Gomez-Cambronero -> c.colmenero.2017@alumnos.urjc.es - colme99

- Álvaro López Sierra -> a.lopezsi.2017@alumnos.urjc.es - alvarolopez99


## Instrucciones para el despliegue de la aplicación

Lo primero, y obviamente, disponer de una máquina virtual y un iso que nos permita lanzar el sistema operativo. Nosotros hemos utilizado Linux, con la versión de Ubuntu 20.04. En nuestro caso, puesto que hemos utilizado colas de mensajes para implementar comunicación, a parte de los pasos habituales que habría que realizar para desplegar la aplicación con la base de datos, es necesario descargar el servidor RabbitMQ para Ubuntu. De esto hablaremos más adelante.
Empezaremos descargando Java (comprende el JDK y el environment de Java, JRE). Estando en la Terminal de Ubuntu, hay que realizar 2 pasos:

- sudo apt install default-jdk
- sudo apt install default-jre

Con esto quedaría instalado Java.
Vamos ahora a instalar MySQL Workbench, que será la base de datos que utilizaremos en la aplicación.
Entramos en la página de MySQL y descargamos la versión para Linux en función de la versión de Ubuntu que hayamos escogido. Una vez descargado, lo instalamos y abrimos nuevamente la consola, donde hay que realizar algunos pasos:

- sudo apt install mysql-server
- sudo mysql_secure_installation (Aquí nos pedirá una contraseña, que debe coincidir con la que hayamos configurado en el properties del proyecto. El resto de preguntas podemos responder yes (y), ya que no influyen en nuestra configuración)
- Si nos preguntan el nivel de seguridad que queremos, debemos responder LOW.
- Si no nos lo preguntan, podemos configurarlo nosotros mismos con: SET GLOBAL validate_password.policy=LOW (Si esto no funciona probar con: SET GLOBAL validate_password_policy=LOW)
- Si todos estos pasos funcionan correctamente, vamos a entrar en mysql, para ello ejecutamos: sudo mysql (Si esto no funciona probar con: sudo mysql -u root -p)
- Si no ha surgido ningún error nos aparecerá el prompt "mysql>". Aquí dentro lo primero que hay que escribir es ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'contraseña_de_nuestra_BD_del_properties';
- Por último, se crea el esquema con el comando CREATE DATABASE 'nombre_esquema_sql_del_properties';
- Indicamos que este esquema es el que queremos usar: USE 'nombre_esquema_sql_del_properties';

Realizando estos pasos, MySQL debería haber quedado instalado.
Por último, antes de ejecutar la aplicación en Ubuntu necesitamos instalar RabbitMQ (Ojo: este paso solo es necesario si tu aplicación hace uso de este servicio). Para descargar RabbitMQ hay que realizar lo siguiente (desde la Terminal): 

- sudo apt-get update -y
- sudo apt-get install curl gnupg debian-keyring debian-archive-keyring -y
- curl -fsSL https://github.com/rabbitmq/signing-keys/releases/download/2.0/rabbitmq-release-signing-key.asc | sudo apt-key add -
- sudo apt-key adv --keyserver "keyserver.ubuntu.com" --recv-keys "F77F1EDA57EBB1CC"
- sudo apt-key adv --keyserver "hkps://keys.openpgp.org" --recv-keys "0x0A9AF2115F4687BD29803A206B73A36E6026DFCA"
- sudo apt-key adv --keyserver "keyserver.ubuntu.com" --recv-keys "F77F1EDA57EBB1CC"
- sudo apt-get install apt-transport-https
- sudo apt-get update -y
- sudo apt-get install -y erlang-base \ erlang-asn1 erlang-crypto erlang-eldap erlang-ftp erlang-inets \ erlang-mnesia erlang-os-mon erlang-parsetools erlang-public-key \ erlang-runtime-tools erlang-snmp erlang-ssl \ erlang-syntax-tools erlang-tftp erlang-tools erlang-xmerl
- sudo apt-get update -y
- curl -1sLf 'https://packagecloud.io/rabbitmq/rabbitmq-server/gpgkey' | apt-key add -
- sudo apt-key adv --keyserver "keyserver.ubuntu.com" --recv-keys "F6609E60DC62814E"
- sudo apt-get install curl gnupg debian-keyring debian-archive-keyring apt-transport-https -y
- sudo apt-get install rabbitmq-server -y --fix-missing
- sudo rabbitmq-server

Si el mensaje indica que RabbitMQ ya está corriendo en el equipo, ya estaría listo para funcionar.
Lo último, sería testear la aplicación desde Windows para arreglar todos los fallos que surjan, y una vez que se sepa que no se va a modificar más la aplicación, se pueden generar los jar. Esto se hace de la siguiente manera:

- Click derecho sobre el proyecto
- Run as.. -> Mavel build...
- En 'Goals' escribir 'clean package'
- Esperar a que la consola de Spring indique 'BUILD SUCCESS'
- Realizar el mismo proceso para el proyecto del servicio interno
- Cuando tengamos los .jar hay que pasarlos a Ubuntu de la manera que se desee (subiéndolos a GitHub y descargando el proyecto de GitHub desde la máquina virtual)
- Desde Ubuntu, abrimos dos terminales al mismo tiempo y, estando cada una de ellas en el directorio donde tenemos generado el .jar, ejecutarlo mediante el comando: java -jar nombre_de_nuestro_jar.jar
- Abrir un navegador en Ubuntu y escribir: https://localhost:8443



## Trello

<https://trello.com/b/bFCFHGyl/sapiotheca>
