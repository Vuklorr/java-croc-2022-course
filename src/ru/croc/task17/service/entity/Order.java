package ru.croc.task17.service.entity;

public record Order(int numberOrder, String login, String article, String name, int cost) {
}
