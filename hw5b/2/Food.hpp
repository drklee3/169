#ifndef FOOD_HPP
#define FOOD_HPP

#include <string>

class Food {
    public:
        std::string name = "food";
        Food();
        Food(std::string name);
        void prepare();
};

#endif

