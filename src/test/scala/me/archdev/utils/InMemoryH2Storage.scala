package me.archdev.utils

import me.archdev.restapi.utils.FlywayService
import org.flywaydb.core.Flyway

object InMemoryH2Storage {
  val dbName = "test"
  val dbUser = "SA"
  val dbPassword = ""
  val jdbcUrl = s"jdbc:h2:mem:$dbName;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS public;MODE=MYSQL;DATABASE_TO_UPPER=false"
  val flyway = new Flyway()
  val flywayService = new FlywayService(jdbcUrl, dbUser, dbPassword)
  flywayService.dropDatabase()
  flywayService.migrateDatabaseSchema()
}
