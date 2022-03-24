<script>
    let character;
 
    let selected = { id: 0, text: " " };

    let characters = [
        { id: 1, text: `Father Rhinehardt` },
        { id: 2, text: `Professor Longfellow` },
        { id: 3, text: `Peter Akimoto` },
        { id: 4, text: `Brandon Jaspers` },
        { id: 5, text: `Jenny LeClerc` },
        { id: 6, text: `Heather Granville` },
        { id: 7, text: `Vivian Lopez` },
        { id: 8, text: `Madame Zostra` },
        { id: 9, text: `Darrin "Flash" Williams` },
        { id: 10, text: `Ox Bellows` },
        { id: 11, text: `Zoe Ingstrom` },
        { id: 12, text: `Miss Dubourde` },
    ];

    async function updateCharacterInfo(e) {
        const response = await fetch(
            `http://localhost:8090/betrayal/api/character?id=${selected.id}`
        );

        if (response.ok) {
            const received = await response.json();
            console.log(received);
            character = received;
        }
    }


</script>

<main>
    <h1>Betrayal Stat Tracker</h1>
    <h2>Character:</h2>
    <select bind:value={selected} on:change={(e) => updateCharacterInfo(e)}>
        {#each characters as selectedCharacter}
            <option value={selectedCharacter}>
                {selectedCharacter.text}
            </option>
        {/each}
    </select>

    {#if character}
        {@html `<p>${character.name}</p>`}
        <p>{character.age}</p>
        <p>{character.speedStats}</p>
        <p>{character.defaultSpIndex}</p>
        <p>{character.mightStats}</p>
        <p>{character.sanityStats}</p>
        <p>{character.knowledgeStats}</p>
    {/if}
</main>

<style>
    main {
        text-align: center;
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }

    h1 {
        color: #832323;
        text-transform: uppercase;
        font-size: 4em;
        font-weight: 150;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }

    
</style>
