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



## Diagramas de la aplicación

### Diagrama de navegación
![](https://github.com/alvarolopez99/Saphioteca/blob/main/DiagramasDAD/DiagramaNavegacion.png)

### Diagrama UML
![](https://github.com/alvarolopez99/Saphioteca/blob/main/DiagramasDAD/UMLDAD.png)

### Diagrama E/R
![](https://github.com/alvarolopez99/Saphioteca/blob/main/DiagramasDAD/ERDAD.png)



## Capturas de Pantalla

A continuación se muestran capturas sobre todas las pantallas importantes de la aplicación, así como una breve explicación de las mismas.


### Pantalla de página principal

La pantalla principal hace referencia a la dirección general de la página, que es la primera que ve el usuario. Desde la pantalla principal se puede acceder a la pantalla de registro, a la pantalla de login, acceder como administrador (para dar de alta a profesores), así como acceder sin necesidad de registrarse.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Bienvenido_a_Sapiotheca.png)


### Pantalla de página de inicio:

La pantalla de página de inicio aparece cuando un usuario se ha hecho login, o bien después de hacer click en "Continuar sin registrarse" si prefiere no crearse cuenta. Desde la pantalla de la página de inicio se pueden acceder a todas las funcionalidades generales de la web, como son los cursos, los foros, el tablón de anuncios y la infomación de perfil. Cabe mencionar también que dentro de cualquier de estas secciones, puedes acceder al resto de secciones a partir del header, así como cerrar sesión.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Página_Inicio.png)


### Pantalla de formulario de registro

Desde el formulario de registro un usuario puede crearse una cuenta en la web. Se ha controlado algunos aspectos mediante scripts (sin necesidad de recargar la página), como que las contraseñas coincidan o que el correo tenga formato de correo, así como hacer los campos obligatorios. La información del usuario incluye su nombre, sus dos apellidos, su correo, el tipo de usuario (alumno o profesor), el tipo de suscripción (estándar o premium), el método de pago (tarjeta de crédito o Paypal), así como foto de perfil.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Formulario_Registro.png)


### Pantalla de login

En esta pantalla el usuario puede iniciar sesión a partir de su correo y contraseña.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Login.png)


### Pantalla de perfil

Desde la pantalla de perfil puede verse toda la información del usuario. Además, en la parte derecha se pueden editar dichos datos con su consiguiente actualización.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Mi_perfil.png)


### Pantalla de lista de cursos disponibles

En esta pantalla se muestran todos los cursos que hayan colgado los profesores. Además, se puede crear nuevos cursos, eliminar los ya existentes, ver su título, ver su resumen, ver el usuario (profesor) que lo ha creado, subir material, crear el examen, resolver el examen, así como acceder al contenido del curso (Ver curso).

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Cursos_Disponibles.png)


### Pantalla para crear curso

El formulario para crear un nuevo curso consta de un título y una descripción. Como se ha mencionado, desde la pantalla de cursos (pantalla anterior) se puede editar el curso así como crear el examen del curso.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Creando_curso.png)


### Pantalla para subir material a un curso

En esta pantalla se suben los materiales (pdf) asociados a un curso. Por supuesto, un curso puede constar de varios materiales.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Subiendo material_a_curso.png)


### Pantalla de mostrar material de un curso

En esta pantalla se muestran todos los materiales que ha subido el profesor en cada curso. Los documentos (pdf) se visualizan directamente en la página.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Mostrar_material_de_curso.png)


### Pantalla para crear el examen de un curso

En esta pantalla el profesor especifica cada una de las cinco preguntas y respuestas que quiere para su examen. Se recuerda que cada curso tiene asociado un examen.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Crear_Examen.png)


### Pantalla para resolver el examen de un curso

En esta pantalla, el usuario (alumno) intenta resolver cada una de las cinco preguntas del examen.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Resolver_examen.png)


### Pantalla para ver los resultados del examen

Una vez resuelto el examen, se muestra el número de preguntas resueltas. 

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Resultado_Examenn.png)


### Ejemplo de envío de certificado utilizando el servicio de correo

Además de mostrar el número de preguntas resueltas, se envía un certificado al correo asociado al usuario si éste ha superado con éxito el examen.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Certificado_Examen Correo.png)


### Pantalla de lista de foros disponibles

En esta pantalla, se muestran todos los foros disponibles. El foro puede utilizarse para que los usuarios (alumnos) publiquen sus dudas.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Foros_Disponibles.png)


### Pantalla para crear foro

En esta pantalla se crean los foros, especificando el asunto del foro así como el mensaje que iniciará dicho foro.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Creando_foro.png)


### Pantalla para contestar a una entrada del foro

Desde el punto de vista de otros usuarios, se puede ver mensajes y contestar en los foros.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Contestando_a_Foro.png)


### Pantalla para intercambiar de mensajes de una entrada del foro

Después de que se le haya cantestado, el usuario puede leer el intercambio de mensajes, así como seguir escribiendo más.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Intercambio_mensajes_Foro.png)


### Pantalla de lista de anuncios

En esta pantalla los usuarios (alumnos) pueden ver los anuncios de clases particulares de los profesores. Por cada anuncio, se visualiza la materia o asignatura y el curso de las clases. Además, los profesores pueden eliminar el anuncio, mientras que los alumnos pueden ver más información del anuncio (Ver anuncio).

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Tablon_de_Anuncios.png)


### Pantalla para ver el contenido de un anuncio publicado

En esta pantalla el usuario (alumno) puede ver toda la información referente al anuncio (incluido el usuario que lo ha creado), así como acceder directamente a un chat para hablar con el usuario que ha creado el anuncio (profesor).

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Mostrar_Ver_anuncio_ya_publicado.png)


### Pantalla para crear anuncio de clases particulares

En esta pantalla el usuario (profesor) especifica la materia o asignatura sobre la que versa el enuncio, el curso al que va dirigido, el precio, el horario, así como una descripción.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Creando_Anuncio_clases_particulares.png)


### Pantalla de lista de chats

En esta pantalla el usuario puede ver los chats que tiene disponibles. En la captura se ve el chat de un profesor con el que un alumno se ha puesto en contacto gracias al anuncio de clases particulares que ha publicado.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Chats.png)


### Pantalla de chat desde el punto de vista del profesor

En esta pantalla se ve el chat de un profesor con un alumno como se ha mencionado previamente. En este caso se trata del intercambio de mensajes de un chat concreto.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Chat_concreto_visto_desde_el_profesor.png)


### Pantalla de registrar a un profesor

En esta pantalla, el administrador puede dar de alta (registrar) a los profesores, de forma similar al registro de alumnos, excepto por el tipo de suscripción y el método de pago.

![](https://github.com/alvarolopez99/Saphioteca/blob/main/CapturasDAD/Administrador_Dar_de_alta_a_un_profesor.png)




## Integrantes del grupo

- Sergio Arévalo Gil -> s.arevalog.2017@alumnos.urjc.es - SergioE17

- Pablo Bayona González -> p.bayona.2017@alumnos.urjc.es - pbayona

- Carlos Colmenero Gomez-Cambronero -> c.colmenero.2017@alumnos.urjc.es - colme99

- Álvaro López Sierra -> a.lopezsi.2017@alumnos.urjc.es - alvarolopez99


## Trello

<https://trello.com/b/bFCFHGyl/sapiotheca>