package helpers;

import builders.UserBuilder;
import entities.User;

public class UserCreation {

    public UserCreation(){

    }

    public User buildUserWithoutCellphone() {
        return new UserBuilder().withName("Juan David").
                withFatherLastname("Orozco").
                withMotherLastName("Llerena").
                withEmail("testjuanorozco6@gmail.com").
                withPassword("test1234").
                withGender("M").
                withCountry("Colombia").
                withDocumentType("CEDULA_DE_CIUDADANIA").
                withNumDocument(1032748964).
                withDay(13).
                withMonth(10).
                withYear(1994).
                create();
    }
}
