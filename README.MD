# Rentit Maintenance Service

This Repository one part of whole system and handles parts related to maintenance of plants  

Specification and requirements 
 
 * https://courses.cs.ut.ee/MTAT.03.229/2017_spring/uploads/Main/PlantHireScenario.pdf
 * https://courses.cs.ut.ee/MTAT.03.229/2017_spring/uploads/Main/2017Project.pdf
 
 
 # API Endpoints
 
 * /api/maintenance
   * POST - plan corrective maintenance
 * /api/maintenance/plans
 * /api/maintenance/tasks
 
 
 
 #Maven
 
 Package without running tests
 
     package -Dmaven.test.skip=true
 
 # Docker Image
 
 ## Build 
 
     docker build -t demonno/rentit-maintenance .
     docker push demonno/rentit-maintenance
 
 Image address: https://hub.docker.com/r/demonno/rentit-maintenance/
 
 Pull Image
 
     docker pull demonno/rentit-maintenance
