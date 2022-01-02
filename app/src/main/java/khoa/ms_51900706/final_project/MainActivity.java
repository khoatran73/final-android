package khoa.ms_51900706.final_project;

import static khoa.ms_51900706.final_project.AddEditNoteActivity.EXTRA_DELETE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import khoa.ms_51900706.final_project.Adapter.NoteAdapter;
import khoa.ms_51900706.final_project.Login.LoginActivity;
import khoa.ms_51900706.final_project.Model.Note;
import khoa.ms_51900706.final_project.Model.NoteDatabase;
import khoa.ms_51900706.final_project.Session.SessionManagement;
import khoa.ms_51900706.final_project.User.User;
import khoa.ms_51900706.final_project.ViewModel.NoteViewModel;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://final-project-c4e36-default-rtdb.asia-southeast1.firebasedatabase.app/");
    DatabaseReference myRef;
    Button logout;
    SessionManagement sessionManagement;
    String uid;
    User user;
    ImageView img;
    TextView name;
    public static final int ADD_NODE_REQUEST = 1;
    public static final int EDIT_NODE_REQUEST = 2;
    public static final int DELETE_NODE_REQUEST = 3;
    private NoteViewModel noteViewModel;
    Button btnSetting, btnExit, btnOpen;
    Boolean isLock;
    private Lock lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManagement = new SessionManagement(MainActivity.this);

        //set font app
        new AppFontManager(this).setFontStyle();

        //set theme app
        setTheme(Constant.theme);

        btnSetting = findViewById(R.id.btnSetting);
        DatabaseHandler db = new DatabaseHandler(this);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(i);
            }
        });


        uid = sessionManagement.getSession();
//
        if (uid.equals("")) {
            moveToLoginActivity();
        }
//
        user = new User();
        user.setUid(uid);
//
//        img = findViewById(R.id.image);
//        name = findViewById(R.id.name);
//
//        myRef = database.getReference("users");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                user = snapshot.child(user.getUid()).getValue(User.class);
//
//                assert user != null;
//                if (user.getImage() != null) {
//                    Picasso.get().load(user.getImage()).into(img);
//                }
//
//                name.setText(user.getName());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                sessionManagement.removeSession();

                moveToLoginActivity();
            }
        });

        FloatingActionButton buttonAddNote = findViewById(R.id.button_add_node);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditNoteActivity.class);
                startActivityForResult(intent, ADD_NODE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Note deleted!", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.SetOnClickListner(new NoteAdapter.OnItemClickListner() {
            @Override
            public void OnItemClick(Note note) {
                Intent intent = new Intent(MainActivity.this, AddEditNoteActivity.class);
                intent.putExtra(AddEditNoteActivity.EXTRA_ID, note.getId());
                intent.putExtra(AddEditNoteActivity.EXTRA_TITLE, note.getTitle());
                intent.putExtra(AddEditNoteActivity.EXTRA_DESCRIPTION, note.getDescription());
                intent.putExtra(AddEditNoteActivity.EXTRA_PRIORITY, note.getPriority());
                startActivityForResult(intent, EDIT_NODE_REQUEST);

            }

        });
    }

    private void moveToLoginActivity() {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NODE_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
            String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
            int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);

            Note note = new Note(title, description, priority);
            noteViewModel.insert(note);

            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
        } else if (requestCode == EDIT_NODE_REQUEST && resultCode == RESULT_OK) {
            if(data.getBooleanExtra(EXTRA_DELETE, true)){
                int id = data.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1);
                if (id == -1) {
                    Toast.makeText(this, "Note can't be deleted", Toast.LENGTH_SHORT).show();
                    return;
                }
                String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
                String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
                int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);

                Note note = new Note(title, description, priority);
                note.setId(id);
                noteViewModel.delete(note);
            }else {
                int id = data.getIntExtra(AddEditNoteActivity.EXTRA_ID, -1);
                if (id == -1) {
                    Toast.makeText(this, "Note can't be updated", Toast.LENGTH_SHORT).show();
                    return;
                }
                String title = data.getStringExtra(AddEditNoteActivity.EXTRA_TITLE);
                String description = data.getStringExtra(AddEditNoteActivity.EXTRA_DESCRIPTION);
                int priority = data.getIntExtra(AddEditNoteActivity.EXTRA_PRIORITY, 1);

                Note note = new Note(title, description, priority);
                note.setId(id);
                noteViewModel.update(note);
            }
        } else {
            Toast.makeText(this, "Note not Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_notes:
                //NoteDatabase.getInstance(this).close();
                noteViewModel.deleteAllNotes();
                Toast.makeText(this, "All notes deleted!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.backup_all_notes:
                int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permission == PackageManager.PERMISSION_GRANTED) {
                    NoteDatabase.getInstance(this).close();

                    File db = getDatabasePath("note_database");

                    File db2 = new File("/sdcard/", "note_database");

                    try {
                        copy(db, db2);
                        if(!NoteDatabase.getInstance(this).isOpen())
                            NoteDatabase.getInstance(this).getOpenHelper().getWritableDatabase().beginTransaction();

                        Toast.makeText(this, "Backup notes successfully!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e("SAVEDB", e.toString());
                        Toast.makeText(this, "Backup notes failed!", Toast.LENGTH_SHORT);
                    }
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
                return true;
            case R.id.restore_all_notes:
                int readPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
                if(readPermission == PackageManager.PERMISSION_GRANTED) {
                    NoteDatabase.getInstance(this).close();

                    File db = new File("/sdcard/", "note_database");

                    File db2 = getDatabasePath("note_database");

                    try {
                        copy(db, db2);
                        if(!NoteDatabase.getInstance(this).isOpen())
                            NoteDatabase.getInstance(this).getOpenHelper().getWritableDatabase().beginTransaction();
                        finish();
                        startActivity(getIntent());
                        Toast.makeText(this, "Restore notes successfully!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e("RESTOREDB", e.toString());
                        Toast.makeText(this, "Restore notes failed!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public static void copy(File src, File dst) throws IOException {
        try (InputStream in = new FileInputStream(src)) {
            try (OutputStream out = new FileOutputStream(dst)) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }
        }
    }
}