package test;

import com.example.tutorial.AddressBookProtos;

import java.io.*;

/**
 * Created by Mirana on 16/1/23.
 */
public class AddPerson {
    static AddressBookProtos.Person PromptForAddress(BufferedReader stdin, PrintStream stdout){
        AddressBookProtos.Person.Builder builder = AddressBookProtos.Person.newBuilder();
        AddressBookProtos.Person john = builder.setId(1234).setName("john").setEmail("john@example.com").
                addPhone(
                        AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("1350000000").setType(AddressBookProtos.Person.PhoneType.HOME))
                .build();
        return john;
    }

    public static void main(String[] args) throws Exception {
        input(args);
    }

    public static void ouput(String[] args) throws Exception {
        File file = new File(args[0]);
        if(!file.exists())
            file.createNewFile();
        FileOutputStream output = new FileOutputStream(args[0]);
        PromptForAddress(null,null).writeTo(output);
        output.close();
    }
    public static void input(String[] args) throws Exception{
        FileInputStream input = new FileInputStream(args[0]);
        AddressBookProtos.Person person = AddressBookProtos.Person.parseFrom(input);
        PrintStream stdout = new PrintStream(System.out);
        stdout.print(person);
    }
}
