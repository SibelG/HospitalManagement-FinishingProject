package com.example.hbyssystemmanagement.View

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.hbyssystemmanagement.Common.Common
import com.example.hbyssystemmanagement.Model.Banner
import com.example.hbyssystemmanagement.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.database.*
import io.paperdb.Paper


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    lateinit var mDatabase : DatabaseReference
    var mAuth = FirebaseAuth.getInstance()
    lateinit var drawer: DrawerLayout
    lateinit var fab: FloatingActionButton
    private lateinit var bottomView:BottomNavigationView
    lateinit var image_slider:HashMap<String,String>
    lateinit var mSlider:SliderLayout
    private lateinit var googleSignInClient: GoogleSignInClient
    private var authStateListener: AuthStateListener? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*var user = mAuth.currentUser
        if (user == null) {
            startActivity(Intent(this@HomeActivity, SignInActivity::class.java))
            finish()
        }*/
        /*authStateListener = AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            // Eğer geçerli bir kullanıcı oturumu yoksa LoginActivity e geçilir.
            // Oturum kapatma işlemi yapıldığında bu sayede LoginActivity e geçilir.
            if (user == null) {
                startActivity(Intent(this@HomeActivity, SignInActivity::class.java))
                finish()
            }
        }*/

        val toolbar = findViewById<View>(R.id.myToolbar) as Toolbar
        setSupportActionBar(toolbar)
        //supportActionBar!!.title = "Menu"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);


        drawer = findViewById<DrawerLayout>(R.id.DrawerLayout)
        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ){
            override fun onDrawerClosed(view:View){
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View){
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        val view = findViewById<NavigationView>(R.id.navView)
        view.setNavigationItemSelectedListener(this)
        val headerView = view.getHeaderView(0)

        //var uid = user!!.uid




        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        setupSlider()

        Paper.init(this)
        /*var UserKey:String=Paper.book().read("User_Key")
        var PassKey:String=Paper.book().read("Pwd_Key")
        if(UserKey!=null && PassKey!=null){
            if(!UserKey.isEmpty() && !PassKey.isEmpty()){
                Login(UserKey,PassKey)
            }
        }*/
        var bottomNavigationView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val firstFragment=AboutFragment()
        val secondFragment=SensesFragment()
        val thirdFragment=TextFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.aboutFragment->setCurrentFragment(firstFragment)
                R.id.SensesFragment->setCurrentFragment(secondFragment)
                R.id.lightTextFragment->setCurrentFragment(thirdFragment)

            }
            true
        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient= GoogleSignIn.getClient(this,gso)
        // Eğer geçerli bir kullanıcı oturumu yoksa LoginActivity e geçilir.
        // Oturum kapatma işlemi yapıldığında bu sayede LoginActivity e geçilir.



    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    private fun Login(userKey: String, passKey: String) {

    if(Common.connectivityInternet(applicationContext)){

        mAuth!!.signInWithEmailAndPassword(userKey, passKey)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    finish()

                }

            }.addOnFailureListener {
                Toast.makeText(this@HomeActivity,"Login in failed",Toast.LENGTH_LONG).show()
            }
    }else{
        Toast.makeText(this, "Please Check Your Connection!", Toast.LENGTH_SHORT).show()
        return
    }

    }


    override fun onStop() {
        super.onStop()
        mSlider.stopAutoCycle()

    }

    override fun onStart() {
        super.onStart()
        mSlider.startAutoCycle()
    }



    private fun setupSlider() {
        mSlider=findViewById(R.id.sliderSection)
        image_slider=HashMap<String,String>()
        var banner:DatabaseReference= FirebaseDatabase.getInstance().getReference("Banner")
        banner.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(Snapshot in snapshot.children){
                    var bannerValue=Snapshot.getValue(Banner::class.java)
                    image_slider.put(bannerValue!!.name!!+"_"+bannerValue!!.id, bannerValue.image!!)


                    for(key:String in image_slider.keys){

                        var keyValue:  List<String> = key.split("_")
                        var name=keyValue[0]
                        var index=keyValue[1]


                        var  textSliderView: TextSliderView= TextSliderView(baseContext)
                        textSliderView.description(name)
                            .image(image_slider.get(key))
                            .setScaleType(BaseSliderView.ScaleType.Fit)
                            .setOnSliderClickListener(BaseSliderView.OnSliderClickListener {
                                var intent=Intent(this@HomeActivity,SectionList::class.java)
                                intent.putExtras(textSliderView.bundle)
                                startActivity(intent)
                            })
                        textSliderView.bundle(Bundle())
                        textSliderView.bundle.putString("SectionId",index)
                        mSlider.addSlider(textSliderView)

                        banner.removeEventListener(this)

                    }


                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
        mSlider.setPresetTransformer(SliderLayout.Transformer.Background2Foreground)
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        mSlider.setDuration(2000)

    }


    /*if(user!=null){
        nameTxt.setText("Welcome " + user!!.displayName)
    }
    nameTxt=findViewById(R.id.userName)*/

       /* mDatabase.child("name").addValueEventListener( object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {

            }
        });*/





 override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_doctor) {
            val intent = Intent(this@HomeActivity, DoctorListActivity::class.java)
            startActivity(intent)
        }else if (id == R.id.nav_section) {
            val intent = Intent(this@HomeActivity, SectionList::class.java)
            startActivity(intent)
        }else if (id == R.id.favourites) {
            val intent = Intent(this@HomeActivity, FavouriteActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.signOut) {

           /* googleSignInClient.signOut().addOnCompleteListener {
                val intent= Intent(this, SignInActivity::class.java)
                Toast.makeText(this,"Logging Out",Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }*/
            Paper.book().destroy()


            mAuth.signOut()
            Toast.makeText(this, "Signed Out ", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@HomeActivity, SignInActivity::class.java))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            finish()
        } else if (id == R.id.changePass) {
            val intent = Intent(this@HomeActivity, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        else if(id==R.id.nav_Appointment) {
            startActivity(Intent(this@HomeActivity, ViewAppointmentActivity::class.java))
        }
        /*
        else if(id==R.id.nav_Visited) {
            intent.putExtra("info", "new")
            startActivity(Intent(applicationContext, VisitedPlacesActivity::class.java))


        }*/ else if(id==R.id.favourites) {
            startActivity(Intent(applicationContext, FavouriteActivity::class.java))
        }else if (id == R.id.nav_nearest_hospital) {
            val intent = Intent(this@HomeActivity, SearchNearPlace::class.java)
            startActivity(intent)
        }

        drawer!!.closeDrawer(GravityCompat.START);
        return true;
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.DrawerLayout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}






