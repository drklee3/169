#include <iostream>
#include <string>
#include "Fruit.hpp"

Fruit::Fruit(time_t ripe, std::string name) {
    std::cout << "Fruit::Fruit()\n";
    this->ripe = ripe;
    this->name = name;
}

void Fruit::ripeTime() {
    std::cout
        << "You can eat it on "
        << time(&this->ripe)
        << std::endl;
}
