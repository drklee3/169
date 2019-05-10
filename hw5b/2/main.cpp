#include <iostream>
#include <time.h>
#include "Apple.hpp"
#include "Food.hpp"
#include "Fruit.hpp"
#include "Orange.hpp"
#include "Tomato.hpp"
#include "Vegetable.hpp"

int main() {
    std::cout << "\n====\nApple:\n====\n";
    new Apple(time(0));
    std::cout << "\n====\nFood:\n====\n";
    new Food();
    std::cout << "\n====\nFruit:\n====\n";
    new Fruit(time(0), "pom");
    std::cout << "\n====\nOrange:\n====\n";
    new Orange(time(0));
    std::cout << "\n====\nVegetable:\n====\n";
    new Vegetable();
    std::cout << "\n====\nTomato:\n====\n";
    Tomato *tom = new Tomato();

    tom->prepare();
    tom->ripeTime();
    tom->expireTime();

    return 0;
}