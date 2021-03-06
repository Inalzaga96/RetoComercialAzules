package com.example.retocomercial;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {


    private String sql = "CREATE TABLE Partners(" +
            "idPartner Integer PRIMARY KEY AUTOINCREMENT," +
            "id_comercial Integer," +
            "nombre varchar(40)," +
            "apellidos varchar(60)," +
            "empresa varchar(50)," +
            "direccion varchar(80)," +
            "telefono varchar(15)," +
            "poblacion varchar(40)," +
            "email varchar(50));";


    private String lineas = "create table lineas(" +
            "cod Integer PRIMARY KEY AUTOINCREMENT," +
            "cod_producto Integer," +
            "cod_pedido Integer," +
            "cod_producto Integer," +
            "Cantidad Integer," +
            "Descuento Integer)";

    private String pedidos="create table pedidos("+
            "cod Integer PRIMARY KEY AUTOINCREMENT,"+
            "id_partner Integer,"+
            "fecha varchar(100))";

    private String login="create table usuarios("+
            "id_comercial Integer PRIMARY KEY AUTOINCREMENT,"+
            "usuario varchar(100) UNIQUE,"+
            "pwd varchar(100))";

    //private String crearUsuarios = "INSERT INTO usuarios(id_comercial,usuario,pwd) VALUES(9223372036854775807,'mikel', '1234');";
    private String crearUsuarios2= "INSERT INTO usuarios(usuario,pwd) VALUES('Kerman', '1234'), ('Iñaki','1234');";
    private String crearPartners= "INSERT INTO partners(id_comercial,nombre,apellidos,empresa,direccion,telefono,poblacion,email) VALUES(1,'Kerman','sorarrain','azules','calle','943268456','Tolosa','kerman@gmail.com'),(1,'mikel','seara','azules','calle','943746218','Andoain','mikel@gmail.com');";
    //private String crearUsuarios2= "INSERT INTO usuarios(usuario,pwd) VALUES('mikel01', '1234')";
    public UsuariosSQLiteHelper(Context contexto, String nombre,
                                SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
        db.execSQL(lineas);
        db.execSQL(pedidos);
        db.execSQL(login);
        //db.execSQL(crearUsuarios);
        db.execSQL(crearUsuarios2);
        db.execSQL(crearPartners);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS COMERCIALES");

        //Se crea la nueva versión de la tabla
        //db.execSQL(sqlCreate);
    }
}
