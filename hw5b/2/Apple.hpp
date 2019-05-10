#ifndef APPLE_HPP
#define APPLE_HPP

#include <string>
#include <time.h>
#include "Fruit.hpp"

class Apple: public Fruit {
    public:
        Apple(time_t ripe);
        void prepare();
};

#endif

