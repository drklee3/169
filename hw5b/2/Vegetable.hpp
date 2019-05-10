#ifndef VEGETABLE_HPP
#define VEGETABLE_HPP

#include <time.h>
#include <string>
#include "Food.hpp"

class Vegetable: public virtual Food {
    private:
        time_t expiration;
    public:
        Vegetable();
        Vegetable(time_t expiration, std::string name);
        void expireTime();
};

#endif

