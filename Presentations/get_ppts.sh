 for lecture in 1 2 3 4 5 6 7 8
 	do
		url=http://home.adelphi.edu/~siegfried/cs343/343l${lecture}.pdf
		echo $url
		curl -O $url
	done

