


def assignment_bb(data_matrix, current, cost):
    next_person_index = len(current)

    combinations = []
    costs = []
    
    pending_jobs = []
    for job in range(n):
        if job not in current:
            pending_jobs.append(job)
   
    for job in pending_jobs:

        new_curr = []
        for old_job in current:
            new_curr.append(old_job)
        new_curr.append(job)

        new_cost = cost + data_matrix[next_person_index][job]
        new_curr, new_cost = assignment_bb(data_matrix, new_curr, new_cost)

        combinations.append(new_curr)
        costs.append(new_cost)

    if(len(costs)):

        min_cost = min(costs)
        minpos = costs.index(min_cost)

        best_combination = combinations[minpos]

        return best_combination, min_cost

    else:
        return current, cost


print("Assignment Problem")
n= int(input("Enter number of jobs:"))

time_per_person = []
print("Enter time taken by each person for each job:")
for person in range(n):
    temp = list(map(int, input().split()))
    time_per_person.append(temp)

job_seq, min_cost  = assignment_bb(time_per_person, [], 0)
 
print("Jobs per person:")
for person in range(n):
    print("Person", person, "does Job", job_seq[person])
print()
print("Total time taken:", min_cost)