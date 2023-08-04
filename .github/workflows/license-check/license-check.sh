#!/opt/homebrew/bin/bash
IFS=$'\n'

readarray -t whitelist < ./.github/workflows/license-check/license-whitelist.txt
readarray -t specialcases < <( grep -vE "^#" ./.github/workflows/license-check/license-special-cases.txt )

exitStatus=0

for specialcase in "${specialcases[@]}"
do
    echo "Special case: " "$specialcase"
done

readarray -t thirdparty < <( tail -n +3 ./target/generated-sources/license/THIRD-PARTY.txt )
for thirdpartyentry in "${thirdparty[@]}"
do   
    allLicensesValid=true
    # Remove leading spaces
    thirdpartyentry="${thirdpartyentry#"${thirdpartyentry%%[![:space:]]*}"}"
    echo "Evaluating Dependency: " "$thirdpartyentry"
    if [[ $(echo "${specialcases[@]}" | fgrep -w $thirdpartyentry) ]]
    then
        echo "  Ignoring: " "$thirdpartyentry"
    else
        licenses=($(echo $thirdpartyentry | awk -vRS=")" -vFS="(" '{print $2}'))
        for (( i=0;  i < ${#licenses[@]} - 1 ; i++ ))
        do
            #echo ${licenses[i]}
            licenseToCheck=${licenses[i]}
            if [[ $(echo "${whitelist[@]}" | fgrep -w $licenseToCheck) ]]
            then
                #do nothing bsh no-op
                :
            else
                echo "  Unknown license found: " $licenseToCheck
                allLicensesValid=false
                exitStatus=1
            fi
        done
    fi
    if $allLicensesValid 
    then
        echo "  All licenses OK"
    else
        echo "  Possible license incompatibilities found"
    fi
done

exit $exitStatus