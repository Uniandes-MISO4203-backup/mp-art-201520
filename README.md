#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-artmarketplace)
  - [Entidad Artist](#entidad-artist)
  - [Entidad Artwork](#entidad-artwork)
  - [Entidad CartItem](#entidad-cartitem)
  - [Entidad Client](#entidad-client)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /ArtMarketPlace.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación ArtMarketPlace
###Entidad Artist
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Artist, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Artist
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    userId: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/artists|Obtener todos los objetos JSON de Artist (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Artist y el total de registros en la base de datos en el header X-Total-Count
**GET**|/artists/:id|Obtener los atributos de una instancia de Artist en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Artist
**POST**|/artists|Crear una nueva instancia de la entidad Artist (CREATE)||Objeto JSON de Artist a crear|Objeto JSON de Artist creado
**PUT**|/artists/:id|Actualiza una instancia de la entidad Artist (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Artist|Objeto JSON de Artist actualizado
**DELETE**|/artists/:id|Borra instancia de Artist en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Artist
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Artist son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|artists/:id/artwork|Obtener Objetos JSON de artwork(Artwork) dependientes de Artist|**@PathParam id**: `id` de instancia de Artist||Colección de objetos JSON de artwork(Artwork)
**POST**|artists/:id/artwork|Creación de instancias de artwork(Artwork) dependientes de Artist|**@PathParam id**: `id` de instancia de Artist|Colección de objetos JSON de artwork(Artwork) a crear|Colección de objetos JSON de artwork(Artwork) creados con sus respectivos ID
**PUT**|artists/:id/artwork|Actualización de instancias de artwork(Artwork) dependientes de Artist|**@PathParam id**: `id` de instancia de Artist|Colección de objetos JSON de artwork(Artwork) a actualizar|Colección de objetos JSON de artwork(Artwork) actualizados
**DELETE**|artists/:id/artwork|Eliminación de instancias de artwork(Artwork) dependientes de Artist|**@PathParam id**: `id` de instancia de Artist|Colección de atributo `id` de artwork(Artwork) a eliminar|

[Volver arriba](#tabla-de-contenidos)

###Entidad Artwork
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Artwork, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Artwork
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    picture: '' /*Tipo String*/,
    price: '' /*Tipo Integer*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/artworks|Obtener todos los objetos JSON de Artwork (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Artwork y el total de registros en la base de datos en el header X-Total-Count
**GET**|/artworks/:id|Obtener los atributos de una instancia de Artwork en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Artwork
**POST**|/artworks|Crear una nueva instancia de la entidad Artwork (CREATE)||Objeto JSON de Artwork a crear|Objeto JSON de Artwork creado
**PUT**|/artworks/:id|Actualiza una instancia de la entidad Artwork (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Artwork|Objeto JSON de Artwork actualizado
**DELETE**|/artworks/:id|Borra instancia de Artwork en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad CartItem
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad CartItem, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto CartItem
```javascript
{
    name: '' /*Tipo String*/,
    artwork: '' /*Objeto que representa instancia de Artwork*/,
    quantity: '' /*Tipo Integer*/,
    id: '' /*Tipo Long*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/cartItems|Obtener todos los objetos JSON de CartItem (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON CartItem y el total de registros en la base de datos en el header X-Total-Count
**GET**|/cartItems/:id|Obtener los atributos de una instancia de CartItem en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de CartItem
**POST**|/cartItems|Crear una nueva instancia de la entidad CartItem (CREATE)||Objeto JSON de CartItem a crear|Objeto JSON de CartItem creado
**PUT**|/cartItems/:id|Actualiza una instancia de la entidad CartItem (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de CartItem|Objeto JSON de CartItem actualizado
**DELETE**|/cartItems/:id|Borra instancia de CartItem en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Client
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Client, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Client
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    userId: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/clients|Obtener todos los objetos JSON de Client (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Client y el total de registros en la base de datos en el header X-Total-Count
**GET**|/clients/:id|Obtener los atributos de una instancia de Client en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Client
**POST**|/clients|Crear una nueva instancia de la entidad Client (CREATE)||Objeto JSON de Client a crear|Objeto JSON de Client creado
**PUT**|/clients/:id|Actualiza una instancia de la entidad Client (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Client|Objeto JSON de Client actualizado
**DELETE**|/clients/:id|Borra instancia de Client en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Client
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Client son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|clients/:id/cartItem|Obtener Objetos JSON de cartItem(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client||Colección de objetos JSON de cartItem(CartItem)
**POST**|clients/:id/cartItem|Creación de instancias de cartItem(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de cartItem(CartItem) a crear|Colección de objetos JSON de cartItem(CartItem) creados con sus respectivos ID
**PUT**|clients/:id/cartItem|Actualización de instancias de cartItem(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de cartItem(CartItem) a actualizar|Colección de objetos JSON de cartItem(CartItem) actualizados
**DELETE**|clients/:id/cartItem|Eliminación de instancias de cartItem(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de atributo `id` de cartItem(CartItem) a eliminar|

[Volver arriba](#tabla-de-contenidos)

