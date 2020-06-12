package com.eeparking.sun.data.repository

/**
 * @author   linhaidong
 * @datetime 2020-06-12 14:39 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class PlantRepository private constructor(
    private val plantDao: PlantDao
) {
    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantId: String) = plantDao.getPlant(plantId)

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

    /**
     *伴生对象,单例模式
     */
    companion object {
        @Volatile
        private var instance: PlantRepository? = null
        fun getInstance(plantDao: PlantDao) = instance ?: synchronized(this) {
            instance ?: PlantRepository(plantDao).also {
                instance = it
            }
        }
    }
}