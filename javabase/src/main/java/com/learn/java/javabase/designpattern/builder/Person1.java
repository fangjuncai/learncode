package com.learn.java.javabase.designpattern.builder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person1 {
    String name;
    int age;
}
/*  编译后再反编译
public class Person1 {
    String name;
    int age;

    Person1(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public static Person1.Person1Builder builder() {
        return new Person1.Person1Builder();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Person1)) {
            return false;
        } else {
            Person1 other = (Person1)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name == null) {
                        return this.getAge() == other.getAge();
                    }
                } else if (this$name.equals(other$name)) {
                    return this.getAge() == other.getAge();
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person1;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $name = this.getName();
        int result = result * 59 + ($name == null ? 43 : $name.hashCode());
        result = result * 59 + this.getAge();
        return result;
    }

    public String toString() {
        return "Person1(name=" + this.getName() + ", age=" + this.getAge() + ")";
    }

    public static class Person1Builder {
        private String name;
        private int age;

        Person1Builder() {
        }

        public Person1.Person1Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Person1.Person1Builder age(final int age) {
            this.age = age;
            return this;
        }

        public Person1 build() {
            return new Person1(this.name, this.age);
        }

        public String toString() {
            return "Person1.Person1Builder(name=" + this.name + ", age=" + this.age + ")";
        }
    }
}

 */