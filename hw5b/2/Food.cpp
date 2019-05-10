#include <iostream>
#include <string>
#include "Food.hpp"

Food::Food() {
    std::cout << "Food::Food()\n";
}

Food::Food(std::string name) {
    std::cout << "Food::Food()\n";
    this->name = name;
}

void Food::prepare() {
    std::cout << "Prepare the " << this->name << std::endl;
}
