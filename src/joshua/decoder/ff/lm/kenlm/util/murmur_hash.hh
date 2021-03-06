#ifndef UTIL_MURMUR_HASH__
#define UTIL_MURMUR_HASH__
#include <cstddef>
#include <inttypes.h>

namespace util {

uint64_t MurmurHash64A(const void * key, std::size_t len, unsigned int seed = 0);
uint64_t MurmurHash64B(const void * key, std::size_t len, unsigned int seed = 0);
uint64_t MurmurHashNative(const void * key, std::size_t len, unsigned int seed = 0);

} // namespace util

#endif // UTIL_MURMUR_HASH__
