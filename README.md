## Proyecto de CRUD java backend

## Funcionalidades
- Ingreso de artículos
- Listado de los artículos existentes
- Consultar un artículo por código
- Modificación de los campos de un artículo
- Eliminar un artículo por código

## Validaciones
- El valor ingresado no está vacío
- En caso de números, se verifica que sea un valor válido
- En caso de los textos, que no esté vacío o con solo espacios
- El código de artículo y de categoría deben ser únicos

## Estructura del proyecto:
herencia_polimorfismo_tostring
│
└── src
│
└── com.techlab.articulo
│
├── App.java
│
└── model
├── Articulo.java
├── ArticuloElectronico.java
├── ArticuloAlimenticio.java
└── Categoria.java

Author: Valeria Moreno
