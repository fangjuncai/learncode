package com.learn.java.javabase.designpattern.builder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class House {
    private String buleprint;
    private String partA;
    private String partB;

    public House(String buleprint, String partA, String partB) {
        this.buleprint =buleprint;
        this.partA = partA;
        this.partB = partB;
    }

    public static HouseBuiler createBuilder(){
        return new HouseBuiler();
    }
/*    public String toString() {
        return "House(buleprint=" + this.getBuleprint() + ", partA=" + this.getPartA() + ", partB=" + this.getPartB() + ")";
    }*/
    //public属性
    @ToString
    public static class HouseBuiler extends Builder {
        private String buleprint;
        private String  partA;
        private String  partB;
        @Override
        public House build(){
            return new House(this.buleprint,this.partA,this.partB);
        }
        @Override
        public HouseBuiler buildPartA(String partA){
            this.partA = partA;
            return this;
        }
        @Override
        public HouseBuiler buildPartB(String partB){
            this.partB = partB;
            return this;
        }
        @Override
        public HouseBuiler buildBuleprint(String buleprint){
            this.buleprint = buleprint;
            return this;
        }
/*        public String toString() {
            return "House.HouseBuiler(buleprint=" + this.buleprint + ", partA=" + this.partA + ", partB=" + this.partB + ")";
        }*/
    }
}
