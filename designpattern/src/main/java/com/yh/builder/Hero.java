package com.yh.builder;

public final class Hero {
    private final String name;
    private final Profession profession;
    private final HairStyle hairStyle;


    public Hero(Builder builder) {
        this.name = builder.name;
        this.profession = builder.profession;
        this.hairStyle = builder.hairStyle;
    }

    public String getName() {
        return name;
    }

    public Profession getProfession() {
        return profession;
    }

    public HairStyle getHairStyle() {
        return hairStyle;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", profession=" + profession +
                ", hairStyle=" + hairStyle +
                '}';
    }

    public static class Builder {
        private final String name;
        private final Profession profession;
        private HairStyle hairStyle;

        public Builder(String name, Profession profession) throws Exception {
            if (profession == null || name == null) {
                throw new Exception("profession and name can not be null!");
            }
            this.name = name;
            this.profession = profession;
        }

        public Builder setHairStyle(HairStyle hairStyle) {
            this.hairStyle = hairStyle;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }


}
