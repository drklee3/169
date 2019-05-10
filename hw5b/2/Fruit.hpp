#ifndef FRUIT_HPP
#define FRUIT_HPP

#include <string>
#include <time.h>
#include "Food.hpp"

class Fruit: public virtual Food {
    private:
        time_t ripe;
    public:
        Fruit(time_t ripe, std::string name);
        void ripeTime();
};

#endif

