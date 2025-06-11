package model;

/**
 * Classe abstrata que representa um contato genérico.
 */

    public abstract class ContactSys implements Contact {
        private String name;
        private String surname;
        private String phoneNumber;
        private String email;

        public ContactSys(String name, String surname, String phoneNumber, String email) {
            this.name = name;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
            if(name != null && name.length() >= 3) {
                this.name = name;
            }
    }

    @Override
    public String getSurname() {
            return surname;
    }
    public void setSurname(String surname) {
            if(surname != null && surname.length() >= 3) {
                this.surname = surname;
            }
    }

    @Override
    public String getPhoneNumber() {
            return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
    }

    @Override
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }

}

