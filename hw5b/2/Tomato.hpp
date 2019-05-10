#ifndef TOMATO_HPP
#define TOMATO_HPP

#include <string>
#include <time.h>
#include "Fruit.hpp"
#include "Vegetable.hpp"

class Tomato: public Fruit, public Vegetable {
    public:
        Tomato();
        Tomato(time_t expiration, time_t ripe, std::string name);
};

#endif