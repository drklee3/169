#ifndef ORANGE_HPP
#define ORANGE_HPP

#include <string>
#include <time.h>
#include "Fruit.hpp"

class Orange: public Fruit {
    public:
        Orange(time_t ripe);
        void prepare();
};

#endif

