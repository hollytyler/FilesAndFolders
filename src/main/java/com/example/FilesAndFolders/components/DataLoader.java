package com.example.FilesAndFolders.components;
import com.example.FilesAndFolders.models.File;
import com.example.FilesAndFolders.models.Folder;
import com.example.FilesAndFolders.models.Person;
import com.example.FilesAndFolders.repositories.FileRepository;
import com.example.FilesAndFolders.repositories.FolderRepository;
import com.example.FilesAndFolders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;

@Profile("!test")
//    @Component //Comment this out if you do not to run the data loader.
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Person holly = new Person("Holly");
        personRepository.save(holly);

        Person liam = new Person("Liam");
        personRepository.save(liam);

        Person steph = new Person("Steph");
        personRepository.save(steph);

        Folder newFolder = new Folder("FolderTitle", holly);
        folderRepository.save(newFolder);

        Folder folder1 = new Folder("Folder1", liam);

        File newFile = new File("File1", ".txt", 5, newFolder);
        fileRepository.save(newFile);

        File file1 = new File("File2", ".java", 1, folder1);




    }
}

