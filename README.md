# Sapioteca

## Temática 
Aplicación para contratar cursos, repositorio para apuntes, videopíldoras. Los contenidos estarían divididos en módulos, a los que los usuarios con un plan standard tendrían acceso a los primeros módulos, mientras que los usuarios premium tendrían acceso a otro tipo de servicios, como módulos completos, acceso a clases personalizadas con un profesor, acceso al foro comunitario para resolución de dudas, obtención de apuntes, chat privado personalizado. 
Los usuarios podrían ver mensajes en el foro escritos por otros usuarios, el primer módulo de los cursos, y los anuncios de los profesores, pero no podrían escribir un nuevo post, o contratar una clase con un profesor. Tampoco pueden ver que otros usuarios están registrados.
Los posts del foro pueden ser escritos por los usuarios que tengan servicio premium, pero los que tengan un plan standard solo podrán visualizarlos. Obviamente, los desarrolladores tienen acceso a esos posts para controlar que no se publique nada ofensivo.
Los post se componen de mensajes, enviados cada uno por un usuario distinto, que incluye el día y hora de envío, usuario que lo envío, y asignatura a la que pertenece.
Los chats serían privados entre un usuario y un profesor, se almacenaría el histórico de mensajes que han intercambiado.
Los anuncios publicados por cada profesor son visibles por todos los usuarios, aunque solo sería posible contratar estos servicios si eres usuario premium.
Los cursos estarían disponibles para todos los usuarios, pero para acceder al curso completo debes estar registrado como usuario premium. Siendo usuario standard solo tienes acceso al primer módulo.
Solo se pueden examinar del curso los usuarios premium, y al completarlo se obtiene un certificado que se enviaría por correo.

## Entidades 
- Usuarios: para registrarse proporcionan nombre, contraseña, método de pago, correo eléctronico, y otros datos como foto de perfil, etc.
- Posts del foro: hilo del foro sobre algún tema, duda, curiosidad, donde puede participar los usuarios premium
- Mensajes: cada uno de los mensajes que contiene un post. Incluyen nombre del usuario que lo ha enviado, y fecha.
- Chats: mensajes privados intercambiados entre dos usuarios registrados, o entre usuario y profesor.
- Anuncios: diferentes mensajes que los profesores ponen en un apartado especial para poder ser contratados
- Cursos: PDFs o videos subidos para que los usuarios puedan visualizarlos directamente. No se pueden descargar.
- Modulos: cada una de las partes en las que se divide un curso de una asignatura concreta
- Correos: los correos se envían a los usuarios premium con el certificado una vez terminado un curso determinado

## Servicio interno
Registro de los usuarios, subida y actualización de contenidos(videos, apuntes), envío de correos con el certificado

## Integrantes del grupo
Sergio Arévalo Gil -> s.arevalog.2017@alumnos.urjc.es - SergioE17

Pablo Bayona González -> p.bayona.2017@alumnos.urjc.es - pbayona

Carlos Colmenero Gomez-Cambronero -> c.colmenero.2017@alumnos.urjc.es - colme99

Álvaro López Sierra -> a.lopezsi.2017@alumnos.urjc.es - alvarolopez99

## Trello
<https://trello.com/b/bFCFHGyl/sapiotheca>
