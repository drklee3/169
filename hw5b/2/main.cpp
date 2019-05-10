#include <iostream>
#include <time.h>
#include "Apple.hpp"
#include "Food.hpp"
#include "Fruit.hpp"
#include "Orange.hpp"
#include "Tomato.hpp"
#include "Vegetable.hpp"

int main() {
    std::cout << "\n====\nFood:\n====\n";
    new Food();
    
    std::cout << "\n====\nFruit:\n====\n";
    new Fruit(time(0), "pom");

    std::cout << "\n====\nApple:\n====\n";
    Apple *appo = new Apple(time(0));
    
    std::cout << "\n====\nOrange:\n====\n";
    Orange *orangie = new Orange(time(0));
    
    std::cout << "\n====\nVegetable:\n====\n";
    Vegetable *vege = new Vegetable();
    
    std::cout << "\n====\nTomato:\n====\n";
    Tomato *tom = new Tomato();

    std::cout << "\n";
    appo->prepare();
    appo->ripeTime();

    std::cout << "\n";
    orangie->prepare();
    orangie->ripeTime();

    std::cout << "\n";
    vege->prepare();
    vege->expireTime();

    std::cout << "\n";
    tom->prepare();
    tom->ripeTime();
    tom->expireTime();

    return 0;
}