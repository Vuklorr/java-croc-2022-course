package ru.croc.task18.entity;

import java.util.List;

public record Order(int numberOrder, String login, List<Product> products) {

}
