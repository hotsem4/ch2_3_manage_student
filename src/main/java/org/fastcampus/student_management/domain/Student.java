package org.fastcampus.student_management.domain;

public class Student {

    private final String name;
    private final int age;
    private final String address;
    private boolean activated;

    public Student(String name, int age, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 필수 입력값입니다.");
        }

        this.name = name;
        this.age = age;
        this.address = address;
        this.activated = true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActivate() {
        return activated;
    }
//    // 내가짠거
//    public void activate() {
//        activated = true;
//    }
//    // 내가짠거
//    public void deactivate() {
//        activated = false;
//    }
    // 강사님코드
    public void activate() {
        if (this.activated) {
            throw new IllegalArgumentException("이미 활성화되어 있습니다.");
        }
        this.activated = true;
    }
    public void deactivate() {
        if (!this.activated) {
            throw new IllegalArgumentException("이미 비활성화되어 있습니다.");
        }
        this.activated = false;
    }

    // 이 로직의 단점은?
    // 내 생각: setter로 변경이 가능해져 데이터가 변경될 가능성이 있음
    // 그래서 특정 값으로만 변경 가능한 메서드를 만들어 하는 것을 추천
//    public void setActivated(boolean activated) {
//        this.activated = activated;
//    }
}
