# Sapiotheca

## Temática 
Aplicación para contratar cursos, repositorio para apuntes y anuncios de clases particulares. Los usuarios premium tendrían acceso a otro tipo de servicios, como acceso al foro comunitario para resolución de dudas o chat privado personalizado con el profesor. 
Los usuarios podrían ver mensajes en el foro escritos por otros usuarios, ciertos contenidos de los cursos, y los anuncios de los profesores, pero no podrían escribir un nuevo post, o contratar una clase con un profesor.
Los posts del foro pueden ser escritos por los usuarios que tengan servicio premium, pero los que tengan un plan standard solo podrán visualizarlos. Obviamente, los administradores tienen acceso a esos posts para controlar que no se publique nada ofensivo.
Los post se componen de mensajes, enviados cada uno por un usuario distinto, que incluye el usuario que lo envío, y el contenido en sí.
Los chats serían privados entre un usuario y un profesor, se almacenaría el histórico de mensajes que han intercambiado.
Los anuncios publicados por cada profesor son visibles por todos los usuarios, aunque solo sería posible contratar estos servicios si eres usuario premium.
Los cursos estarían disponibles para todos los usuarios.
Solo se pueden examinar del curso los usuarios premium, y al completarlo se obtiene un certificado que se enviaría por correo.
Los profesores pueden crear nuevos cursos y crear un examen por cada curso.



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
- Notificaciones del foro: Cuando un usuario mande un mensaje al foro el servicio interno informa de ese mensaje al usuario que creó dicho foro de dudas.
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


## Trello

<https://trello.com/b/bFCFHGyl/sapiotheca>
