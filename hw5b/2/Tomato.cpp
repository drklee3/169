#include <time.h>
#include <iostream>
#include <string>
#include "Tomato.hpp"

Tomato::Tomato(): Fruit(time(0), "tomato"), Vegetable(time(0), "tomato") {
    std::cout << "Tomato::Tomato()\n";
}

Tomato::Tomato(time_t expiration, time_t ripe, std::string name):
    Fruit(ripe, name), Vegetable(expiration, name) {
    std::cout << "Tomato::Tomato()\n";
}


