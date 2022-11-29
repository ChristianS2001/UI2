package edu.temple.ui2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.action_take_picture -> Toast.makeText(this, "You click the Take Picture option", Toast.LENGTH_SHORT)
            R.id.action_help -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            R.id.action_delete -> {
                AlertDialog.Builder(this)
                    .setTitle("Delete Confirmation")
                    .setMessage("Are you sure you want to delete this picture?")
                    .setPositiveButton("Yes"){_,_ -> Toast.makeText(this, "Picture Deleted", Toast.LENGTH_SHORT)}
                    .setNegativeButton("No"){dialog,_ -> dialog.cancel()}
                    .setCancelable(false)
                    .create()
                    .show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}