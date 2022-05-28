package com.example.hbyssystemmanagement.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.hbyssystemmanagement.Model.Favourites

class Database(context: Context?,factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DBname, factory, dbVersion) {

    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val query = ("CREATE TABLE " + table + " ("
                + " DoctorId" + " TEXT PRIMARY KEY," +
                "Name" + " TEXT," +
                "Image" + " TEXT," +
                "Section" + " TEXT," +
                "UserEmail" +  " TEXT" + ")")


        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + table)
        onCreate(db)
    }
    fun addFavourites(item:Favourites ){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put("DoctorId",item.DoctorId)
        values.put("Name", item.Name)
        values.put("Image", item.Image)
        values.put("Section",item.Section)
        values.put("UserEmail",item.UserEmail)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(table, null, values)

        // at last we are
        // closing our database
        db.close()
    }
    class Database(){}




    @SuppressLint("Range")
    fun getAllFavlist(): ArrayList<Favourites> {
        val list = ArrayList<Favourites>()
        val db = this.readableDatabase
        val query = "SELECT * FROM " + table
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val favourites = Favourites()
            favourites.DoctorId = cursor.getString(cursor.getColumnIndex("DoctorId"))
            favourites.Name = cursor.getString(cursor.getColumnIndex("Name"))
            favourites.Image = cursor.getString(cursor.getColumnIndex("Image"))
            favourites.Section = cursor.getString(cursor.getColumnIndex("Section"))
            favourites.UserEmail = cursor.getString(cursor.getColumnIndex("UserEmail"))

            list.add(favourites)
        }
        db.close()
        return list
    }


    fun deleteFavourites(doctorId: String?,UserEmail:String?) {
        val db = this.writableDatabase
        db.delete(table, "DoctorId=? AND UserEmail=?" , arrayOf(doctorId, UserEmail))
        db.close()
    }

    fun isFavourite(doctorId: String?,UserEmail:String?): Boolean {
        val db = readableDatabase
        val query = String.format(
            "SELECT * FROM  $table WHERE DoctorId = ? AND UserEmail = ?", arrayOf(doctorId, UserEmail)
        )
        val cursor = db.rawQuery(query, null)
        return if (cursor.count <= 0) {
            cursor.close()
            false
        } else {
            true
        }
    }



    /*val countCart: Int
        get() {
            var count = 0
            val db = readableDatabase
            val query = String.format("SELECT COUNT(*) FROM OrderDetail")
            val cursor = db.rawQuery(query, null)
            if (cursor.moveToFirst()) {
                do {
                    count = cursor.getInt(0)
                } while (cursor.moveToNext())
            }
            return count
        }*/


    companion object {
        private const val DBname = "EntityDb.db"
        private const val dbVersion = 1
        private const val table= "Favourites"
    }
}