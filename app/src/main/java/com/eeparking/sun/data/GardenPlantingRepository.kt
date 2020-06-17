package com.eeparking.sun.data

/**
 * @author   linhaidong
 * @datetime 2020-06-16 14:58 GMT+8
 * @email lin894542913@vip.qq.com
 * @detail :
 */
class GardenPlantingRepository private constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {
    suspend fun createGardenPlanting(plantId: String) {
        val gardenPlanting = GardenPlanting(plantId)
        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    fun isPlanted(plantId: String) {
        gardenPlantingDao.isPlanted(plantId)
    }

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()

    companion object {
        @Volatile
        private var instance: GardenPlantingRepository? = null

        fun getInstance(gardenPlantingDao: GardenPlantingDao) = instance ?: synchronized(this) {
            instance ?: GardenPlantingRepository(gardenPlantingDao).also {
                instance = it
            }
        }
    }
}