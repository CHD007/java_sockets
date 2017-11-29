package ru.spb.etu.GUI;

public enum GeometricAction {
    TRIANGLE_AREA(1, "Площадь треугольника по строне и высоте"),
    ROMBUS_AREA(2, "Площадь ромба по длине стороны и высоте"),
    REACTANGLE_PERIMETER(3, "Периметр прямоугольника через две стороны"),
    ORB_VALUE(4, "Объем шара по радиусу");

    private String description;
    private int id;

    GeometricAction(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public int getId() {
        return id;
    }
}
