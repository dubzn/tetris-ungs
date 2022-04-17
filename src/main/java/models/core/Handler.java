package models.core;

public interface Handler <T> {
    void handle(T request);
}
