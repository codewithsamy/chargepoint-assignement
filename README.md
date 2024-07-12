# chargepoint-assignement

Algorithm:
1. Sorting: Trucks are sorted in descending order based on the remaining charge they need.
             This ensures that trucks needing less charge are prioritized.
2. Greedy Assignment: Iterate over each truck and find the charger that can fully charge it in the shortest time within the                             available hours.
3. Updating Schedule: If a suitable charger is found, schedule the truck on that charger, update the available hours, and mark                          the truck as fully charged.

Approach:
The approach involves sorting the trucks based on their remaining charge needed (descending order) and greedily assigning each truck to the charger that can fully charge it in the least amount of time. 

This approach ensures that trucks are scheduled optimally based on their charging needs and charger capacities.
