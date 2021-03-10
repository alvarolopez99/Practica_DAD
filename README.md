# Sapiotheca

## Temática 
Aplicación para contratar cursos, repositorio para apuntes, videopíldoras. Los contenidos estarían divididos en cursos, a los que los usuarios con un plan standard tendrían acceso solo a algunos, mientras que los usuarios premium tendrían acceso a otro tipo de servicios, como cursos completos, acceso al foro comunitario para resolución de dudas, obtención de apuntes, chat privado personalizado. 
Los usuarios podrían ver mensajes en el foro escritos por otros usuarios, ciertos contenidos de los cursos, y los anuncios de los profesores, pero no podrían escribir un nuevo post, o contratar una clase con un profesor.
Los posts del foro pueden ser escritos por los usuarios que tengan servicio premium, pero los que tengan un plan standard solo podrán visualizarlos. Obviamente, los desarrolladores tienen acceso a esos posts para controlar que no se publique nada ofensivo.
Los post se componen de mensajes, enviados cada uno por un usuario distinto, que incluye el usuario que lo envío, y el contenido en sí.
Los chats serían privados entre un usuario y un profesor, se almacenaría el histórico de mensajes que han intercambiado.
Los anuncios publicados por cada profesor son visibles por todos los usuarios, aunque solo sería posible contratar estos servicios si eres usuario premium.
Los cursos estarían disponibles para todos los usuarios, pero para acceder al curso completo debes estar registrado como usuario premium. Siendo usuario standard solo tienes acceso a ciertos contenidos.
Solo se pueden examinar del curso los usuarios premium, y al completarlo se obtiene un certificado que se enviaría por correo.

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

## Integrantes del grupo
Sergio Arévalo Gil -> s.arevalog.2017@alumnos.urjc.es - SergioE17

Pablo Bayona González -> p.bayona.2017@alumnos.urjc.es - pbayona

Carlos Colmenero Gomez-Cambronero -> c.colmenero.2017@alumnos.urjc.es - colme99

Álvaro López Sierra -> a.lopezsi.2017@alumnos.urjc.es - alvarolopez99

## Trello
<https://trello.com/b/bFCFHGyl/sapiotheca>
