public class BuilderPattern3 {
    public static void main(String[] args) {
        _Person person = new _Person(12, "sds", "sure");
        System.out.println(person);

        System.out.println(_Person.builder()
                .setAge(12)
                .setName("alex")
                .build());
    }
}

class _Person {
    private int age;
    private String name;
    private String surname;

    public _Person(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "_Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static class PersonBuilder{
        private int age;
        private String name;
        private String surname;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setAge (int age) {
            this.age = age;
            return this;
        }

        public _Person build(){
            return new _Person(age, name, surname);
        }
    }
}
