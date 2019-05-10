#include <time.h>
#include <iostream>
#include <string>
#include "Food.hpp"
#include "Vegetable.hpp"

Vegetable::Vegetable(): Food("vegetable") {
    std::cout << "Vegetable::Vegetable()\n";
    this->expiration = time(0);
}

Vegetable::Vegetable(time_t expiration, std::string name): Food(name) {
    this->expiration = expiration;
}

void Vegetable::expireTime() {
    std::cout
        << "It will expire on "
        << time(&this->expiration)
        << std::endl;
}