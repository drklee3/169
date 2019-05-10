#include <iostream>
#include <string>
#include "Apple.hpp"

Apple::Apple(time_t ripe): Fruit(ripe, "apple") {
    std::cout << "Apple::Apple()\n";
}

void Apple::prepare() {
    std::cout << "Core the " << this->name << std::endl;
}
