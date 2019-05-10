#include <iostream>
#include <string>
#include "Orange.hpp"

Orange::Orange(time_t ripe): Fruit(ripe, "orange") {
    std::cout << "Orange::Orange()\n";
}
